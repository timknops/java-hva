package practicumopdracht.views;

import javafx.scene.Parent;

/**
 * Parent class of all views.
 *
 * @author Tim Knops
 */
public abstract class View {

    private Parent root;

    /** Constructor. */
    public View() {
        root = initializeView();
    }

    /**
     * Creates the view.
     *
     * @return  the root node of the view
     * */
    protected abstract Parent initializeView();

    /** Returns the root node of the created view. */
    public Parent getRoot() {
        return root;
    }
}
