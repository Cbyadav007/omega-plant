


async function fetchData()
{
    try{
        let url = "http://localhost:8890/admin/allcustomers";
        let res = await fetch(url);
        let data = await res.json();
        console.log(data);
        data.forEach(function (e) {
            console.log("e = ",e.userName);
        });
    }
    catch(error)
    {
        console.log("Erorr: ",error);
    }
}



document.querySelector("#fetchbut").addEventListener("click",fetchData);


// ///////////////////////////////////////////////////////////////////////////////////////////////

//  first request - to - server to create order

const paymentStart = () =>{
    console.log("Payment Started....");
    // let amount = document.querySelector("#payment_field").value;
    let amount = $("#payment_field").val();
    console.log(amount);
    if(amount == '' || amount == null)
    {
        // alert("Amount is required !!!");
        swal("Failed!", "amount is required!", "error");

        return;
    }
    


    $.ajax(
        {
            url: 'http://localhost:8890/user/create_order',
            data:JSON.stringify({amount:amount, info:'order_request'}),
            contentType:'application/json',
            type:'POST',
            dataType:'json',
            success:function(response){
                //  invoked hen success
                console.log("response = ",response);

                if(response.status == "created")
                {
                    ////////   Open Payment Form    //////////////

                    var options = {
                        key: "rzp_test_ES7a9RUuflN6Pn", // Enter the Key ID generated from the Dashboard
                        amount: "50000", // Amount is in currency subunits. Default currency is
                        currency: "INR",
                        name: "Omega-Plant",
                        description: "Payment to Cb Yadav for Omega-Plant",
                        image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5iC9Pz1-1TPhcZ-8TtljyBJTp7j0skmH8Lg&usqp=CAU",
                        order_id: response.id, 
                    
                        handler: function (response){

                            console.log("Payment Id : ",response.razorpay_payment_id);
                            console.log("Order Id : ",response.razorpay_order_id);
                            console.log("Signature : ",response.razorpay_signature)
                            // alert("Congrates!! Payment successfull...")
                            swal("Congrates!", "Payment Successfull!", "success");


                        // alert(response.razorpay_payment_id);
                        // alert(response.razorpay_order_id);
                        // alert(response.razorpay_signature)
                        },
                        prefill: {
                        name: "",
                        email: "",
                        contact: ""
                        },
                        notes: {
                        address: "Omega-Plant Office, Varanasi,UP"
                                },
                    theme: {
                    color: "#3399cc"
                    }
                   };
                   var rzp1 = new Razorpay(options);
                   rzp1.on('payment.failed', function (response){
                    alert(response.error.code);
                    alert(response.error.description);
                    alert(response.error.source);
                    alert(response.error.step);
                    alert(response.error.reason);
                    alert(response.error.metadata.order_id);
                    alert(response.error.metadata.payment_id);
                    // alert("Oops! Payment Failed");
                    swal("Failed!", "Payment Failed!", "error");
                   });

                   rzp1.open();

                //    document.getElementById('rzp-button1').onclick = function(e){
                //     rzp1.open();
                //     e.preventDefault();
                //    }



                }


            },
            error:function(error)
            {
                // invoked when error
                console.log(error);
                alert("Somrthing went Wrong !!!");
            }
        }
    )

};

// document.querySelector(".paytbn").addEventListener("click", paymentStart);


