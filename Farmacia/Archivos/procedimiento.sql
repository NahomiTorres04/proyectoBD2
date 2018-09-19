delimiter //
DROP PROCEDURE IF EXISTS insertar_producto //
DROP PROCEDURE IF EXISTS insertar_sustancias //
CREATE PROCEDURE insertar_producto(vnombre_producto VARCHAR(45), vdescripcion_producto VARCHAR(70), 
		vnombre_presentacion VARCHAR(45), vdescrip_presentacion VARCHAR(60), vno_lote INT, 
        vfecha_caducidad DATE, vcantidad INT, vcosto FLOAT, vprecio FLOAT)

BEGIN
	DECLARE vid_producto INT UNSIGNED DEFAULT 0;
    DECLARE vid_presentacion INT UNSIGNED DEFAULT 0;
	
    INSERT INTO producto(nombre_producto, descripcion) VALUES(vnombre_producto, vdescripcion_producto);
    INSERT INTO presentacion(nombre) VALUE(vnombre_presentacion);
    
    SELECT MAX(id) INTO vid_producto FROM producto;
    SELECT MAX(id) INTO vid_presentacion FROM presentacion;
    
    INSERT INTO detalle_presentacion(presentacion_id, producto_id, presentacion) VALUES(vid_producto, 
			vid_presentacion, vdescrip_presentacion);
            
	INSERT INTO lote(no_lote, f_caducidad, cantidad, costo, precio, producto_id) VALUES(vno_lote, 
			vfecha_caducidad, vcantidad, vcosto, vprecio, vid_producto);   
END //

CREATE PROCEDURE insertar_sustancias(vnombre_sustancia VARCHAR(45))

BEGIN
	DECLARE vid_producto INT UNSIGNED DEFAULT 0;
    DECLARE vid_sustancia INT UNSIGNED DEFAULT 0;
    SELECT MAX(id) INTO vid_producto FROM producto;
    
    INSERT INTO sustancias(nombre_sustancia) VALUE(vnombre_sustancia);
    SELECT MAX(id) INTO vid_sustancia FROM sustancias;
    
    INSERT INTO detalle_sustancia(sustancias_id, producto_id) VALUES(vid_sustancia, vid_producto);
END //
delimiter ;
