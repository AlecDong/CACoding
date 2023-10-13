package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;

import java.io.IOException;

public class ClearUseCaseFactory {
    private ClearUseCaseFactory(){}

    public static ClearController createClearUseCase (ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, ClearUserDataAccessInterface clearDataAccessObject) throws IOException {
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(viewManagerModel, signupViewModel);
        ClearInputBoundary clearInputInteractor = new ClearInteractor(clearDataAccessObject, clearOutputBoundary);
        return new ClearController(clearInputInteractor);
    }
}
