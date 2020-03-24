import {combineReducers} from 'redux'
import errorReducer from './errorReducer'

//all reducers meet here
//this combineReducer is the main reducer that goes into the store
export default combineReducers({
    //error reducer
    errors: errorReducer
    
});