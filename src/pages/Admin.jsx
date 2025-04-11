import { useState, useEffect } from "react";
import axios from "axios";
import "./Admin.css";

function Admin() {
  const [producto, setProducto] = useState({
    producto_nombre: "",
    producto_marca: "",
    producto_descripcion: "",
    producto_precio: "",
    producto_categoria: "",
    producto_cantidad: "",
  });
  console.log(producto);


  const [imagen, setImagen] = useState(null);
  const [productos, setProductos] = useState([]);

  useEffect(() => {
    cargarProductos();
  }, []);

  const cargarProductos = async () => {
    const res = await axios.get("http://localhost:8080/productos");
    setProductos(res.data);
  };

  const handleInput = (e) => {
    setProducto({ ...producto, [e.target.name]: e.target.value });
  };

  const handleImagen = (e) => {
    setImagen(e.target.files[0]);
  };

  const crearProducto = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    for (let key in producto) {
      formData.append(key, producto[key]);
    }
    if (imagen) {
      formData.append("producto_imagen", imagen);
    }

    await axios.post("http://localhost:8080/productos", formData);
    setProducto({
      producto_nombre: "",
      producto_marca: "",
      producto_descripcion: "",
      producto_precio: "",
      producto_categoria: "",
      producto_cantidad: "",
    });
    setImagen(null);
    cargarProductos();
  };

  const eliminarProducto = async (id) => {
    await axios.delete(`http://localhost:8080/productos/${id}`);
    cargarProductos();
  };

  return (
    <div className="contenedor">
      <h2>Crear Producto</h2>
      <form onSubmit={crearProducto}>
        <input name="producto_nombre" placeholder="Nombre" onChange={handleInput} value={producto.producto_nombre} />
        <input name="producto_marca" placeholder="Marca" onChange={handleInput} value={producto.producto_marca} />
        <input name="producto_descripcion" placeholder="Descripción" onChange={handleInput} value={producto.producto_descripcion} />
        <input name="producto_precio" type="number" placeholder="Precio" onChange={handleInput} value={producto.producto_precio} />
        <input name="producto_categoria" placeholder="Categoría" onChange={handleInput} value={producto.producto_categoria} />
        <input name="producto_cantidad" type="number" placeholder="Cantidad" onChange={handleInput} value={producto.producto_cantidad} />
        <input type="file" onChange={handleImagen} />
        <button type="submit">Crear</button>
      </form>

      <h3>Productos</h3>
      {productos.map((p) => (
        <div key={p.id_Producto} className="producto">
          <p>Nombre: {p.producto_nombre}</p>
          <p>Marca: {p.producto_marca}</p>
          <p>Descripción: {p.producto_descripcion}</p>
          <p>Precio: {p.producto_precio}</p>
          <p>Categoría: {p.producto_categoria}</p>
          <p>Cantidad: {p.producto_cantidad}</p>
          {p.producto_imagen && (
  <img src={`http://localhost:8080/uploads/${p.producto_imagen}`} alt={p.producto_nombre} className="img-producto" />
)}


          <button onClick={() => eliminarProducto(p.id_Producto)}>Eliminar</button>
        </div>
      ))}
    </div>
  );
}

export default Admin;
