client=(function(){

	return {
		getBoard:function(callback){
			$.get(`http://20.81.92.137:80/board`, function(data) {callback(data)});
		},
		getPlayers:function(callback){
        	$.get(`http://20.81.92.137:80/board/players`, function(data) {callback(data)});
        },
		putNamePlayer:function(name){
		   return $.ajax({
               url: `http://20.81.92.137:80/board/players/${name}`,
               type: 'PUT',
               data: name,
               contentType: "application/json"
           });
		},
		putPlayerMovement:function(movement){
           return $.ajax({
               url: `http://20.81.92.137:80/board/players/${movement.player}/${movement.movement}`,
               type: 'PUT',
               data: JSON.stringify(movement),
               contentType: "application/json"
           });
        }
	}

})();