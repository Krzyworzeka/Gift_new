package com.example.action;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/action")
public class ActionController {

    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @Operation(summary = "All actions.", description = "Get list of all actions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ActionDTO.class))),
            @ApiResponse(responseCode = "404", description = "Actions cannot be found")
    })
    @GetMapping
    public ResponseEntity<List<ActionDTO>> getAction(){
        List<ActionDTO> actions = actionService.getAll();
        if(actions.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(actions);
        }
    }

    @Operation(summary = "Add action.", description = "Create new action")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ActionDTO.class)))
    })
    @PostMapping
    public ResponseEntity<ActionDTO> addAction(@RequestBody @Valid ActionDTO action){
        ActionDTO actionDTO = actionService.addAction(action);
        return ResponseEntity.ok(actionDTO);
    }
    @GetMapping("getAction/{id}")
    public ResponseEntity<ActionDTO> getById(@Parameter  @PathVariable Long id){
        ActionDTO dto = actionService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update action.", description = "Update action")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = ActionDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<ActionDTO> updateMovie(@PathVariable Long id, @RequestBody ActionDTO actionDTO){
        ActionDTO dto = actionService.updateAction(id, actionDTO);
        return ResponseEntity.ok(dto);
    }


}
