package use_case.clear_users;

// TODO Complete me

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;


    public ClearInteractor(ClearUserDataAccessInterface userDataAccessObject,
                           ClearOutputBoundary clearPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.clearPresenter = clearPresenter;
    }

    @Override
    public void execute() {
        String deletedUsers = userDataAccessObject.clear();
        ClearOutputData clearOutputData = new ClearOutputData(false);
        clearPresenter.prepareSuccessView(clearOutputData, deletedUsers);
    }
}
