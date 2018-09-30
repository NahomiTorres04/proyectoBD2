delimiter //
DROP function IF EXISTS actualizar //
create function actualizar(pnombre varchar(45),pcantidad int) returns boolean
begin
	declare var_idp integer unsigned default 0;
    declare var_cant integer signed default 0;
    declare var_idv integer unsigned default 0;
    declare var_precio integer unsigned default 0;
    declare var_cont integer unsigned default 0;
    select count(id) into var_cont from producto where nombre_producto=pnombre;
    if(var_cont=1)then
		select id into var_idp from producto where nombre_producto=pnombre;
        update lote set cantidad=cantidad-pcantidad where producto_id=var_idp;
        select cantidad into var_cant from lote where producto_id=var_idp;
        select max(id) into var_idv from venta;
        select precio into var_precio from lote where producto_id=var_idp;
		update venta set total=total+(var_precio*pcantidad) where id=var_idv;
		insert into detalle_venta(venta_id,producto_id,precio,cantidad)values (var_idv,var_idp,var_precio,pcantidad);
        return var_cant>=0;
    else
		return false;
    end if;
    
end;//
delimiter ;