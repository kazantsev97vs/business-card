import {updateUser} from "./update-reducers/update-user";

const reducer = (state, action) => {
    return {
        user: updateUser(state, action),
    };
};

export default reducer;