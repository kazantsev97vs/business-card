import {userActionTypes} from "../../action-types/";

export const updateUser = (state, action) => {

    if (state === undefined) {
        return {
            user: null,
            loading: false,
            error: null,
        }
    }

    switch (action.type) {


        // CREATE USER --------------------------------

        case userActionTypes.FETCH_CREATE_USER_REQUEST:
            return {
                user: null,
                loading: true,
                error: null
            };

        case userActionTypes.FETCH_CREATE_USER_SUCCESS:
            return {
                user: action.payload,
                loading: false,
                error: null
            };

        case userActionTypes.FETCH_CREATE_USER_FAILURE:
            return {
                user: null,
                loading: false,
                error: action.payload
            };


        // LOGIN USER --------------------------------

        case userActionTypes.FETCH_LOGIN_USER_REQUEST:
            return {
                user: null,
                loading: true,
                error: null
            };

        case userActionTypes.FETCH_LOGIN_USER_SUCCESS:
            return {
                user: action.payload,
                loading: false,
                error: null
            };

        case userActionTypes.FETCH_LOGIN_USER_FAILURE:
            return {
                user: null,
                loading: false,
                error: action.payload
            };


        // LOGOUT USER --------------------------------

        case userActionTypes.FETCH_LOGOUT_USER_REQUEST:
            return {
                ...state.user,
                loading: true,
                error: null
            };

        case userActionTypes.FETCH_LOGOUT_USER_SUCCESS:
            return {
                user: null,
                loading: false,
                error: null
            };

        case userActionTypes.FETCH_LOGOUT_USER_FAILURE:
            return {
                ...state.user,
                loading: false,
                error: action.payload
            };


        // UPDATE USER --------------------------------

        case userActionTypes.FETCH_UPDATE_USER_REQUEST:
            return {
                ...state.user,
                loading: true,
                error: null
            };

        case userActionTypes.FETCH_UPDATE_USER_SUCCESS:
            return {
                user: action.payload,
                loading: false,
                error: null
            };

        case userActionTypes.FETCH_UPDATE_USER_FAILURE:
            return {
                ...state.user,
                loading: false,
                error: action.payload
            };


        // DEFAULT CASE -------------------------------

        default:
            return state.user;
    }
};