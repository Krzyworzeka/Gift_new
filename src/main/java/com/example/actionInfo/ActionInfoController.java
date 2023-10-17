package com.example.actionInfo;

import com.example.action.ActionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/info")
public class ActionInfoController {

    private final ActionInfoService actionInfoService;

    public ActionInfoController(ActionInfoService actionInfoService) {
        this.actionInfoService = actionInfoService;
    }

    @Operation(summary = "Get new.", description = "Get all news about actions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ActionDTO.class))),
            @ApiResponse(responseCode = "404", description = "News cannot be found")
    })
    @GetMapping
    public ResponseEntity<List<ActionInfoDto>> getAction(){
        List<ActionInfoDto> actions = actionInfoService.getAll();
        if(actions.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(actions);
        }
    }
    @Operation(summary = "Add new info", description = "Add new info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ActionDTO.class))),
            @ApiResponse(responseCode = "404", description = "Info cannot be add")
    })
    @PostMapping("/addInfo")
    public ResponseEntity<ActionInfoDto> addInfo(@RequestBody @Valid ActionInfoDto actionInfoDto){
        ActionInfoDto actionInfo = actionInfoService.addActionInfo(actionInfoDto);
        return ResponseEntity.ok(actionInfo);
    }

    @Operation(summary = "Add end info", description = "Add new info about end of action")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ActionDTO.class)))
    })
    @PostMapping("/EndInfo/{id}")
    public ResponseEntity<ActionInfoDto> EndInfo(@PathVariable Long id){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String text = String.join(": " , df.format(now),"Action is end.Thank you for your commitment");
        ActionInfoDto actionInfoDto = actionInfoService.addActionInfo(new ActionInfoDto(id, text));
        return ResponseEntity.ok(actionInfoDto);
    }

}
