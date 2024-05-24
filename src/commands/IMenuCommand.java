package commands;

import java.io.IOException;

@FunctionalInterface
public interface IMenuCommand {
//----------------------------------------------------------
    public boolean get() throws EmptyInputException;
//----------------------------------------------------------
}
