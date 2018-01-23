<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $.getJSON("demo_ajax_json.txt", function(result){
            $.each(result, function(i, field){
                $("div").append(field + " ");
            });
        });
    });
});
</script>
</head>
<body>

<button>Get JSON data</button>

<div></div>

</body>
</html>
