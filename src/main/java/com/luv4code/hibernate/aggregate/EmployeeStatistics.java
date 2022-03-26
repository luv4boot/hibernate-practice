package com.luv4code.hibernate.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeStatistics {
    private Long empCount;
    private Double avgSal;
    private Double minSal;
    private Double sumOfSal;
}
