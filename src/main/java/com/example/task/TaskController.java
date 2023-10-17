package com.example.task;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Add new task", description = "Create task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = TaskDTO[].class)))
    })
    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody @Valid TaskDTO dto) {
        TaskDTO taskDTO = taskService.addTask(dto);
        return ResponseEntity.ok(taskDTO);
    }

    @Operation(summary = "Gets all tasks", description = "Gets list of all task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = TaskDTO[].class))),
            @ApiResponse(responseCode = "404", description = "Tasks cannot be found")
    })
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        List<TaskDTO> tasks = taskService.getAll();
        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tasks);
        }
    }
    @Operation(summary = "GUpdate task", description = "Update task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = TaskDTO[].class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDTO taskDTO) {
        TaskDTO dto = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(dto);
    }
    @Operation(summary = "Drop task", description = "Drop task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = TaskDTO[].class)))
    })

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "End flag", description = "End flag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = TaskDTO[].class)))
    })
    @GetMapping("done/{id}")
    public ResponseEntity<Boolean> isActionDone(@PathVariable Long id) {
            return ResponseEntity.ok(taskService.isActionDone(id));
    }

    @Operation(summary = "progressAction", description = "Return the percent complete of the task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response",
                    content = @Content(schema = @Schema(implementation = TaskDTO[].class)))
    })
    @GetMapping("progress/{id}")
    public ResponseEntity<String> progressAction(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.progressAction(id));
    }
}
