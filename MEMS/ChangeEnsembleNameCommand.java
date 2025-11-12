/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: ChangeEnsembleNameCommand.java
 */

public class ChangeEnsembleNameCommand extends AbstractCommand {

    private final String requestedNewName;

    private EnsembleNameMemento memento;   // holds ensemble ref + old/new names

    public ChangeEnsembleNameCommand(MEMSContext ctx,
                                     CommandManager manager,
                                     String newName) {
        super(ctx, manager,
              "Change ensemble's name to " + newName);
        this.requestedNewName = newName;
    }

    @Override
    public void execute() {
        // First execution: create memento
        if (memento == null) {
            Ensemble current = ctx.getCurrent();
            if (current == null) {
                System.out.println("No current ensemble selected.");
                return;
            }

            String oldName = current.getName();
            memento = new EnsembleNameMemento(current, oldName, requestedNewName);
        }

        // Apply "redo" side of the memento
        Ensemble e = memento.getEnsemble();
        e.setName(memento.getNewName());
        System.out.println("Ensemble's name is updated.");
    }

    @Override
    public void undo() {
        if (memento == null) {
            return;
        }

        Ensemble e = memento.getEnsemble();
        e.setName(memento.getOldName());
    }
}

