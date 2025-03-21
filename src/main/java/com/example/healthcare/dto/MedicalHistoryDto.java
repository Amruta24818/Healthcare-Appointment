package com.example.healthcare.dto;

import com.example.healthcare.model.User;
import lombok.Data;

@Data
public class MedicalHistoryDto {

    private String diagnosis;
    private String summary;
    private User user;
}
