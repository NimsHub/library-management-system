package org.nims.ui;

import org.nims.library.Library;

public class UIFactory {
    private final Library library;

    public UIFactory(Library library) {
        this.library = library;
    }
    public UIContract getUI(UI ui) {
        if (ui == UI.CLI)
        {
            CLI cli = CLI.getInstance(library);
            return cli;
        }
        else{ return new GUI(library);}
    }
}