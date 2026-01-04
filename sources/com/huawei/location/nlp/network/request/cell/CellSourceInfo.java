package com.huawei.location.nlp.network.request.cell;

import java.util.List;

/* loaded from: classes8.dex */
public class CellSourceInfo {
    private CurrentCell currentCell;
    private List<NeighborCell> neighborCells;

    public CellSourceInfo(CurrentCell currentCell, List<NeighborCell> list) {
        this.currentCell = currentCell;
        this.neighborCells = list;
    }

    public CurrentCell getCurrentCell() {
        return this.currentCell;
    }

    public List<NeighborCell> getNeighborCells() {
        return this.neighborCells;
    }

    public void setCurrentCell(CurrentCell currentCell) {
        this.currentCell = currentCell;
    }

    public void setNeighborCells(List<NeighborCell> list) {
        this.neighborCells = list;
    }
}
