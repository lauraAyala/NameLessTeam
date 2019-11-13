import React, { Component } from 'react';
import { registrarProducto } from './api/Api';


export default class RegistrarProducto extends Component {
  constructor(props) {
     super(props);
 
     this.state = {
      
      idCodigo: '', 
      descripcion:'',
      precioCompra:'',
      precioVenta:'',
      error: ''
    
       
     };

     this.changeIdCodigo = this.changeIdCodigo.bind(this);
     this.changeDescripcion = this.changeDescripcion.bind(this);
     this.changePrecioCompra = this.changePrecioCompra.bind(this);
     this.changePrecioVenta = this.changePrecioVenta.bind(this);
     this.executeRegister = this.executeRegister.bind(this);
   }


  changeIdCodigo(event){
    this.setState({idCodigo: event.target.value});
  }

  changeDescripcion(event) {
    this.setState({ descripcion: event.target.value });
  }
  

  /*changeAplicarDescuento(event) {
    this.setState({ aplicaDescuento: event.target.value });
  }

  changeAplicarPromo(event) {
    this.setState({ aplicaPromo: event.target.value });
  }*/

  changePrecioCompra(event) {
    this.setState({ precioCompra: event.target.value });
  }

  changePrecioVenta(event) {
    this.setState({ precioVenta: event.target.value });
  }

  executeRegister() {
    registrarProducto({ idCodigo: this.state.idCodigo, descripcion: this.state.descripcion, precioCompra: this.state.precioCompra, precioVenta: this.state.precioVenta})
    .then((res)=>{   
      console.log(res)
      this.props.history.push('/home');  
    
    
    }).catch((error) => { this.setState({error:error.response.data.message})
                  
                   
    })

  }    

  renderInput(label, value, inputType, onChange) {
    return (
      <div className="form-group row">
        <label className="col-sm-3 col-form-label">{label}</label>
        <div className="col-sm-9">
          <input type={inputType} className="form-control" value={value} onChange={onChange} />
        </div>
      </div>
    );
  }

  render() {
    return (

      <div className="container">
        <div className="row centerRow">
          <div className="col-3" />
          <div className="col-6 card newCard">
            <div className="card-body">
              
              {this.renderInput('IdCodigo', this.state.idCodigo, 'text', this.changeIdCodigo)}
              {this.renderInput('Descripcion', this.state.descripcion, 'text', this.changeDescripcion)}
              {this.renderInput('PrecioCompra', this.state.precioCompra, 'text', this.changePrecioCompra)}
              {this.renderInput('PrecioVenta', this.state.precioVenta, 'text', this.changePrecioVenta)}



              <div className="col-12">
                <button type="button" className="btn btn-primary btn-block" onClick={this.executeRegister}>Registrar</button>
              </div> 
            </div>
          </div>
        </div>
      </div>
    );
  }
}

