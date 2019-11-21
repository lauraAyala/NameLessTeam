import React from 'react';
import axios from 'axios';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {withRouter} from "react-router";
import Producto from "./Producto";
import Table from "react-bootstrap/Table";


class ProductosEnStock extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            productos: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:7000/productos/')
            .then(response => {
                this.setState({productos: response.data});
                console.log("GET productos: ", response)
            })
            .catch(error => console.log("**** ERROR ****", error.toJSON()))
    }

    renderProductos() {
        const {productos} = this.state;
        if (productos.length === 0) {
            return <div>Todavia no hay Productos Registrados</div>
        }
        return (
            <div className="listaDeProductos">
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <th>IdCodigo</th>
                        <th>Descripcion</th>
                        <th>Precio De Compra</th>
                        <th>Precio De Venta</th>
                        <th>Stock</th>
                    </tr>
                    </thead>
                    <tbody>
                    {productos.map(prod => <Producto data={prod}/>)}
                    </tbody>
                </Table>
            </div>
        )
    }

    render() {
        return (
            <div className={"MainPageMiddle"}>
                <h1>Stock De Productos Registrados</h1>
                {this.renderProductos()}
            </div>
        )
    }

}

export default withRouter(ProductosEnStock)