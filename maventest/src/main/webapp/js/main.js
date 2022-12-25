function get_data() {
  const customer_id = document.getElementById("customer_id").value;

  $("#dg").datagrid({
    toolbar: "#tb",
    queryParams: {
      customer_id: customer_id,
    },
    url: "customer",
    method: "get",
    emptyMsg: "NO DATA",
    singleSelect: true,
    striped: true,
    rownumbers: true,
    columns: [
      [
        { field: "customer_id", title: "Customer ID" },
        { field: "store_id", title: "Store ID" },
        { field: "first_name", title: "First Name" },
        { field: "last_name", title: "Last Name" },
        { field: "email", title: "Email" },
        { field: "address_id", title: "Address ID" },
        { field: "active", title: "Active" },
        { field: "create_date", title: "Create Date" },
        { field: "payment_id", title: "Payment ID" },
        { field: "staff_id", title: "Staff ID" },
        { field: "rental_id", title: "Rental ID" },
        { field: "amount", title: "Amount" },
        { field: "payment_date", title: "Payment Date" },
        { field: "last_update", title: "Last Update" },
      ],
    ],
  });
}
