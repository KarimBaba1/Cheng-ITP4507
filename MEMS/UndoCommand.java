/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: UndoCommand.java
 */


public class UndoCommand extends AbstractCommand {

    public UndoCommand(MEMSContext ctx,
                       CommandManager manager) {
        super(ctx, manager, "Undo", false);
    }

    @Override
    public void execute() {
        manager.undo();
    }

    @Override
    public void undo() {
        // no-op
    }
}
