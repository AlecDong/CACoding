package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;
import view.SignupView;

public class ClearPresenter implements ClearOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;
    public ClearPresenter(ViewManagerModel viewManagerModel,
                          SignupViewModel signupViewModel){
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response, String message) {
        SignupState signupState = signupViewModel.getState();
        signupState.setClearMessage(message);
        signupViewModel.firePropertyChanged();
    }
}
