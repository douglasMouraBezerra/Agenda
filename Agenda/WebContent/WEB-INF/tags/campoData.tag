<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>

<br/>
<input type="text" id="${id }" name="${id}" />


<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yyy'
	});
</script>
