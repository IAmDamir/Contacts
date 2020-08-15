interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command, Movable {
    Movable entity;
    int previousX = 0;
    int PreviousY = 0;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        previousX = xMovement;
        PreviousY = yMovement;
        entity.setX(xMovement);
        entity.setY(yMovement);
    }

    @Override
    public void undo() {
        setX(previousX);
        setY(PreviousY);
    }

    @Override
    public int getX() {
        return entity.getX();
    }

    @Override
    public int getY() {
        return entity.getY();
    }

    @Override
    public void setX(int newX) {
        xMovement = newX;
    }

    @Override
    public void setY(int newY) {
        yMovement = newY;
    }
}

class CommandPutItem implements Command, Storable {
    Storable entity;
    int index;
    String item;

    @Override
    public int getInventoryLength() {
        return entity.getInventoryLength();
    }

    @Override
    public String getInventoryItem(int index) {
        return entity.getInventoryItem(index);
    }

    @Override
    public void setInventoryItem(int index, String item) {
        this.item = entity.getInventoryItem(index);
        for (int i = 0; i < entity.getInventoryLength(); i++) {
            if (entity.getInventoryItem(i) == null) {
                this.item = item;
                break;
            }
        }
    }


    @Override
    public void execute() {
        for (int i = 0; i < entity.getInventoryLength(); i++)
        if (entity.getInventoryItem(index) == null) {
            entity.setInventoryItem(index, item);
        }
    }

    @Override
    public void undo() {
        entity.setInventoryItem(, null);
    }
}