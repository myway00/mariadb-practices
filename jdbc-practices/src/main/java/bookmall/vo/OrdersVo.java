package bookmall.vo;

public class OrdersVo {

    private int no;
    private int orderNo;
    private int price;
    private String address;

    private int memberNo;
    private String memberName;

    public OrdersVo() {
        this.orderNo = 1;
    }

    public OrdersVo(int orderNo, String memberName, int price, String address) {
        super();
        this.orderNo = 1;
        this.price = price;
        this.address = address;
        this.memberName = memberName;
    }

    public OrdersVo(int no, int orderNo, int price, String address, int memberNo, String memberName) {
        super();
        this.no = no;
        this.orderNo = 1;
        this.price = price;
        this.address = address;
        this.memberNo = memberNo;
        this.memberName = memberName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return String.format("주문 리스트    [주문번호=%s, 주문자=%s, 총 금액=%s, 주소=%s ]", orderNo, memberName, price, address);
    }

}