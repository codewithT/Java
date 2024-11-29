package com.ims.InventoryManagementSystem.Controller;


import com.ims.InventoryManagementSystem.Dto.OrderDto;
import com.ims.InventoryManagementSystem.Dto.RequestsDTO.OrderRequestDto;
import com.ims.InventoryManagementSystem.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("IMS/order")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        OrderDto orderDto = orderService.createOrder(orderRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable Long id){
        OrderDto orderDto = orderService.getOrderDetails(id);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/allOrders")
    public ResponseEntity<Page<OrderDto>> listAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<OrderDto> orderDtoPage = orderService.listAllOrders(page, size);

        return ResponseEntity.ok(orderDtoPage);
    }

}
