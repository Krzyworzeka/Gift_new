package com.example.actionInfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/info")

public class ActionInfoController {

    private final ActionInfoService actionInfoService;

    public ActionInfoController(ActionInfoService actionInfoService) {
        this.actionInfoService = actionInfoService;
    }


    @GetMapping
    public ResponseEntity<List<ActionInfoDto>> getAction(){
        List<ActionInfoDto> actions = actionInfoService.getAll();
        if(actions.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(actions);
        }
    }

    @PostMapping
    public ResponseEntity<ActionInfoDto> addInfo(@RequestBody @Valid ActionInfoDto actionInfoDto){
        ActionInfoDto actionInfo = actionInfoService.addActionInfo(actionInfoDto);
        return ResponseEntity.ok(actionInfoDto);
    }

      @PostMapping("/{id}")
    public ResponseEntity<ActionInfoDto> addStandardInfo(@PathVariable Long id){
        String text = "";
        ActionInfoDto actionInfoDto = actionInfoService.addActionInfo(new ActionInfoDto(id, text));
        return ResponseEntity.ok(userInfoDto);
    }
}
