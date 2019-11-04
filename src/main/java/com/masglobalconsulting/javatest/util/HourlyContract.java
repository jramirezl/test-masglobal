package com.masglobalconsulting.javatest.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HourlyContract implements ContractInt {

    private double hourlySalary;

    @Override
    public Double calculateSalary() {
        return hourlySalary * Constants.HOURS_PER_MONTH * Constants.MONTHS_PER_YEAR;
    }
}
