$(function () {		
	 $.ajax(
	    {
	        'url': "http://localhost:8080/stats",
	        'method' : "get",
	        'async' : 'true',
	        'success': function(result){
	            //-------------
	            //- BAR CHART -
	            //-------------
	        	var labels = []
	        	var values = []
	        	$.each(result, function(index,value) {
	        		labels.push(index); 
	        		values.push(value);
	            });
	            var barChartCanvas = $("#barChart").get(0).getContext("2d");
	            var barChart = new Chart(barChartCanvas);
	            var barChartData = {
	            	      labels: labels,
	            	      datasets: [
	            	        {
	            	          label: "Salary",
	            	          fillColor: "rgba(0, 192, 239, 1)",
	            	          strokeColor: "rgba(0, 192, 239, 1)",
	            	          pointColor: "rgba(0, 192, 239, 1)",
	            	          pointStrokeColor: "#00c0ef",
	            	          pointHighlightFill: "#00c0ef",
	            	          pointHighlightStroke: "rgba(0, 192, 239, 1)",
	            	          data: values
	            	        }
	            	     
	            	      ]
	            	    };
	            var barChartOptions = {
	              //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
	              scaleBeginAtZero: true,
	              //Boolean - Whether grid lines are shown across the chart
	              scaleShowGridLines: true,
	              //String - Colour of the grid lines
	              scaleGridLineColor: "rgba(0,0,0,.05)",
	              //Number - Width of the grid lines
	              scaleGridLineWidth: 1,
	              //Boolean - Whether to show horizontal lines (except X axis)
	              scaleShowHorizontalLines: true,
	              //Boolean - Whether to show vertical lines (except Y axis)
	              scaleShowVerticalLines: true,
	              //Boolean - If there is a stroke on each bar
	              barShowStroke: true,
	              //Number - Pixel width of the bar stroke
	              barStrokeWidth: 2,
	              //Number - Spacing between each of the X value sets
	              barValueSpacing: 5,
	              //Number - Spacing between data sets within X values
	              barDatasetSpacing: 1,
	              //String - A legend template
	              //Boolean - whether to make the chart responsive
	              responsive: true,
	              maintainAspectRatio: true
	            };

	            barChartOptions.datasetFill = false;
	            barChart.Bar(barChartData, barChartOptions);
	        }
	 });
	 
	 $.ajax(
			    {
			        'url': "http://localhost:8080/decile",
			        'method' : "get",
			        'async' : 'true',
			        'success': function(result){
			            //-------------
			            //- BAR CHART -
			            //-------------
			        	var labels = []
			        	var values = []
			        	var data = []
			        	var color = ["#f56954",]
			        	var sum = 0;
			        	$.each(result, function(index,value) {
			        		labels.push(index); 
			        		values.push(value);
			        		sum = sum + value;
			            });
			        	
			        	for(var i = 0;i < 10 ;i++){
			        		values[i] = parseFloat((values[i]/sum)*100).toFixed(2);
			        		if(i!=9){
			        			labels[i] = "<"+labels[i]
			        		}else{
			        			labels[i] = ">="+labels[i]
			        		} 
			        	}
			        	
			        	 var barChartCanvas = $("#barChart1").get(0).getContext("2d");
				            var barChart = new Chart(barChartCanvas);
				            var barChartData = {
				            	      labels: labels,
				            	      datasets: [
				            	        {
				            	          label: "Salary",
				            	          fillColor: "rgba(0, 166, 90, 1)",
				            	          strokeColor: "rgba(0, 166, 90, 1)",
				            	          pointColor: "rgba(0, 166, 90, 1)",
				            	          pointStrokeColor: "#00a65a",
				            	          pointHighlightFill: "#00a65a",
				            	          pointHighlightStroke: "rgba(0, 166, 90, 1)",
				            	          data: values
				            	        }
				            	     
				            	      ]
				            	    };
				            var barChartOptions = {
				              //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
				              scaleBeginAtZero: true,
				              //Boolean - Whether grid lines are shown across the chart
				              scaleShowGridLines: true,
				              //String - Colour of the grid lines
				              scaleGridLineColor: "rgba(0,0,0,.05)",
				              //Number - Width of the grid lines
				              scaleGridLineWidth: 1,
				              //Boolean - Whether to show horizontal lines (except X axis)
				              scaleShowHorizontalLines: true,
				              //Boolean - Whether to show vertical lines (except Y axis)
				              scaleShowVerticalLines: true,
				              //Boolean - If there is a stroke on each bar
				              barShowStroke: true,
				              //Number - Pixel width of the bar stroke
				              barStrokeWidth: 2,
				              //Number - Spacing between each of the X value sets
				              barValueSpacing: 5,
				              //Number - Spacing between data sets within X values
				              barDatasetSpacing: 1,
				              //String - A legend template
				              //Boolean - whether to make the chart responsive
				              responsive: true,
				              maintainAspectRatio: true
				            };

				            barChartOptions.datasetFill = false;
				            barChart.Bar(barChartData, barChartOptions);
						        	
			       
			        		
			        	}
			        	
			   
			           
			        
			 });	 
    


  });