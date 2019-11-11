import React from 'react';
import './App.css';
import {Route, Switch} from 'react-router';
import {BrowserRouter} from 'react-router-dom';
import Home from './Home';
import RegistrarCliente from "./RegistrarCliente";


function App() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/home" render={props => <Home user={props.location.state}/>}/>
                <Route path="/registrarCliente" render={props => <RegistrarCliente user={props.location.state}/>}/>
                <Route path="/" render={props => <Home {...props} />}/>
            </Switch>
        </BrowserRouter>

    );

}


export default App;

