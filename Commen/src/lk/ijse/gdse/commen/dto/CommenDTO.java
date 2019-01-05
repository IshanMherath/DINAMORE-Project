package lk.ijse.gdse.commen.dto;

public class CommenDTO extends SuperDTO {
    private CustomerDTO customerDTO;
    private PlaceOrderDTO placeOrderDTO;
    private OrdersDTO ordersDTO;

    public CommenDTO() {
    }

    public CommenDTO(CustomerDTO customerDTO, PlaceOrderDTO placeOrderDTO, OrdersDTO ordersDTO) {
        this.customerDTO = customerDTO;
        this.placeOrderDTO = placeOrderDTO;
        this.ordersDTO = ordersDTO;
    }

    public CommenDTO(PlaceOrderDTO placeOrderDTO, OrdersDTO ordersDTO) {
        this.placeOrderDTO = placeOrderDTO;
        this.ordersDTO = ordersDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public PlaceOrderDTO getPlaceOrderDTO() {
        return placeOrderDTO;
    }

    public void setPlaceOrderDTO(PlaceOrderDTO placeOrderDTO) {
        this.placeOrderDTO = placeOrderDTO;
    }

    public OrdersDTO getOrdersDTO() {
        return ordersDTO;
    }

    public void setOrdersDTO(OrdersDTO ordersDTO) {
        this.ordersDTO = ordersDTO;
    }
}
