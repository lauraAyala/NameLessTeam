import './componente/App.css';
import React from 'react';
import {Route, Switch} from 'react-router';
import {BrowserRouter} from 'react-router-dom';
import Home from './componente/Home';
import RegistrarCliente from "./componente/RegistarCliente";
import RegistrarProducto from './componente/RegistrarProducto';
import ClientesActivos from "./componente/ClientesActivos";
import NavBar from "./componente/NavBar"
import ProductosEnStock from "./componente/ProductosEnStock";
import RealizarVenta from "./componente/RealizarVenta";


function App() {
    return (
        <BrowserRouter>
            <NavBar/>
            <Switch>
                <Route path="/home" render={props => <Home user={props.location.state}/>}/>
                <Route path="/registrarCliente" render={props => <RegistrarCliente user={props.location.state}/>}/>
                <Route path="/registrarProducto" component={RegistrarProducto}/>
                <Route path="/registrarVenta" component={RealizarVenta}/>
                <Route path="/clientes" render={props => <ClientesActivos user={props.location.state}/>}/>
                <Route path="/productos" render={props => <ProductosEnStock user={props.location.state}/>}/>
                <Route path="/" render={props => <Home {...props} />}/>
            </Switch>
        </BrowserRouter>

    );

}


export default App;