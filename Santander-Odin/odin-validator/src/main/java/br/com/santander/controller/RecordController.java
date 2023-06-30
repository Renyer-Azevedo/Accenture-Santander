package br.com.santander.controller;

import br.com.santander.domain.mapper.RecordMapper;
import br.com.santander.domain.response.RecordResponse;
import br.com.santander.service.RecordService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class RecordController {
    @Inject
    private RecordService recordService;
    @Inject
    private RecordMapper recordMapper;

    @Operation(summary = "Returns all records")
    @APIResponse(responseCode = "200",
            description = "Returns all success and error records.",
            content = @Content(//
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(//
                            implementation = RecordResponse.class,
                            type = SchemaType.OBJECT)))
    @GetMapping("/v1/records")
    @ResponseStatus(HttpStatus.OK)
    public RecordResponse getAllRecords() {
        log.info("retrieves all records.");
        return recordMapper.voToResponse(recordService.getAllRecord());
    }

}
