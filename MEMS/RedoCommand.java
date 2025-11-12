/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: RedoCommand.java
 */


public class RedoCommand extends AbstractCommand {

    public RedoCommand(MEMSContext ctx,
                       CommandManager manager) {
        super(ctx, manager, "Redo", false);
    }

    @Override
    public void execute() {
        manager.redo();
    }

    @Override
    public void undo() {
        // no-op
    }
}
