package com.example.E_commerce_chala.controller;


import com.example.E_commerce_chala.models.Producto;
import com.example.E_commerce_chala.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {

    @Autowired
    ProductoServices productoServices;
   //try {
     //   return ResponseEntity.status(HttpStatus.CREATED)
       //         .body(this.userService.saveUser(requestData));
    //} catch (Exception error) {
      //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());

    //}
//}

    @PostMapping
    public ResponseEntity <?> save(@RequestBody Producto solicitarDatos){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.productoServices.guardarProducto(solicitarDatos));
        }catch (Exception error){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity  <?>  buscarTodosProductos(){
        try {
          return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServices.buscartodosProductos());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServices.buscarProductoPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).
                    body(error.getMessage());
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity <?> modificarProducto (@PathVariable Integer id,@RequestBody Producto datosProducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServices.modificarProductoPorId(id, datosProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).
                    body(error.getMessage());
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <?> eliminarProducto (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServices.eliminarProducto(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }




























































}
