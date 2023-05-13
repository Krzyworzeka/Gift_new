package com.example.actionInfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
