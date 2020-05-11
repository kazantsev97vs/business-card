import {userActionTypes} from '../action-types';


// CREATE ACTION ON USER --------------------------------------------------------------------------------------------

export const fetchCreateUserRequest = () => ({type: userActionTypes.FETCH_CREATE_USER_REQUEST});
export const fetchCreateUserSuccess = (user) => ({type: userActionTypes.FETCH_CREATE_USER_SUCCESS, payload: user});
export const fetchCreateUserFailure = (error) => ({type: userActionTypes.FETCH_CREATE_USER_FAILURE, payload: error});


// LOGIN ACTION ON USER ---------------------------------------------------------------------------------------------

export const fetchLoginUserRequest = () => ({type: userActionTypes.FETCH_LOGIN_USER_REQUEST});
export const fetchLoginUserSuccess = (user) => ({type: userActionTypes.FETCH_LOGIN_USER_SUCCESS, payload: user});
export const fetchLoginUserFailure = (error) => ({type: userActionTypes.FETCH_LOGIN_USER_FAILURE, payload: error});


// LOGOUT ACTION ON USER --------------------------------------------------------------------------------------------

export const fetchLogoutUserRequest = () => ({type: userActionTypes.FETCH_LOGOUT_USER_REQUEST});
export const fetchLogoutUserSuccess = () => ({type: userActionTypes.FETCH_LOGOUT_USER_SUCCESS});
export const fetchLogoutUserFailure = (error) => ({type: userActionTypes.FETCH_LOGOUT_USER_FAILURE, payload: error});


// UPDATE ACTION ON USER --------------------------------------------------------------------------------------------

export const fetchUpdateUserRequest = () => ({type: userActionTypes.FETCH_UPDATE_USER_REQUEST});
export const fetchUpdateUserSuccess = (user) => ({type: userActionTypes.FETCH_UPDATE_USER_SUCCESS, payload: user});
export const fetchUpdateUserFailure = (error) => ({type: userActionTypes.FETCH_UPDATE_USER_FAILURE, payload: error});