import React, {Component} from 'react';
import {registrarProducto} from './api/Api';
import Form from "react-bootstrap/Form";


export default class RegistrarProducto extends Component {
    constructor(props) {
        super(props);

        this.state = {
            idCodigo: '',
            descripcion: '',
            precioCompra: '',
            precioVenta: '',
            stock: '',
            error: ''
        };

        this.changeIdCodigo = this.changeIdCodigo.bind(this);
        this.changeDescripcion = this.changeDescripcion.bind(this);
        this.changePrecioCompra = this.changePrecioCompra.bind(this);
        this.changePrecioVenta = this.changePrecioVenta.bind(this);
        this.changeStock = this.changeStock.bind(this);
        this.executeRegister = this.executeRegister.bind(this);
    }


    changeIdCodigo(event) {
        this.setState({idCodigo: event.target.value});
    }

    changeDescripcion(event) {
        this.setState({descripcion: event.target.value});
    }

    changeStock(event) {
        this.setState({stock: event.target.value});
    }

    /*changeAplicarDescuento(event) {
      this.setState({ aplicaDescuento: event.target.value });
    }

    changeAplicarPromo(event) {
      this.setState({ aplicaPromo: event.target.value });
    }*/

    changePrecioCompra(event) {
        this.setState({precioCompra: event.target.value});
    }

    changePrecioVenta(event) {
        this.setState({precioVenta: event.target.value});
    }

    executeRegister() {
        registrarProducto({
            idCodigo: this.state.idCodigo,
            descripcion: this.state.descripcion,
            precioCompra: this.state.precioCompra,
            precioVenta: this.state.precioVenta,
            stock: this.state.stock
        })
            .then((res) => {
                console.log(res)
                this.props.history.push('/');


            }).catch((error) => {
            this.setState({error: error.response.data.title})

        })

    }

    handleClickBack() {
        this.props.history.push(`/`);
    }

    renderInput(label, value, inputType, onChange) {
        return (
            <div className="form-group row">
                <label className="col-sm-3 col-form-label">{label}</label>
                <div className="col-sm-9">
                    <input type={inputType} className="form-control" value={value} onChange={onChange}/>
                </div>
            </div>
        );
    }

    render() {
        return (
            <div className="RegistrarProducto">
                <div className="container flex-center">
                    <Form>

                        <h1> Registrar Producto </h1>
                        <div className="FormContainer ">
                            <Form.Row
                                className="p30">{this.renderInput('IdCodigo', this.state.idCodigo, 'text', this.changeIdCodigo)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('Descripcion', this.state.descripcion, 'text', this.changeDescripcion)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('PrecioCompra', this.state.precioCompra, 'numeric', this.changePrecioCompra)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('PrecioVenta', this.state.precioVenta, 'numeric', this.changePrecioVenta)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('Stock', this.state.stock, 'numeric', this.changeStock)}</Form.Row>
                        </div>
                        <div className="col-12 p30 flex-center ">
                            <button type="button" className="btn btn-primary" onClick={this.executeRegister}>Registrar
                            </button>
                            <button type="button" className=" btn btn-secondary ml-1rem "
                                    onClick={() => this.handleClickBack()}>Volver
                            </button>
                        </div>
                        <div className="col-12 " >
                                {this.state.error && this.state.error}
                        </div>
                    </Form>
                </div>
            </div>
        );
    }
}

