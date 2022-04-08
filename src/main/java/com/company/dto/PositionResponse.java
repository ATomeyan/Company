package com.company.dto;

import com.company.model.Position;

import java.util.List;

public class PositionResponse extends SingleResponse{

    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}