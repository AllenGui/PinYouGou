app.controller('baseController', function($scope) {
	// 分页控件配置
	$scope.paginationConf = {
		currentPage : 1,
		totalItems : 10,
		itemsPerPage : 10,
		perPageOptions : [ 10, 20, 30, 40, 50 ],
		onChange : function() {// 页面变更
			$scope.reloadList();// 刷新
		}
	};

	// 刷新列表
	$scope.reloadList = function() {
		$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
	}
	
	// 用户勾选的id集合
	$scope.selectIds = [];

	// 用户复选勾选
	$scope.updateSelection = function($event, id) {
		if ($event.target.checked) {// 如果是被选中,则增加到数组
			$scope.selectIds.push(id);// 向集合中添加元素
		} else {
			var index = $scope.selectIds.indexOf(id);// 查找值的位置
			$scope.selectIds.splice(index, 1);// 参数1:移除的位置; 参数2:移除的个数
		}
	}
	
	// 处理页面json数据
	$scope.jsonToString = function(jsonString, key) {
		var json = JSON.parse(jsonString);
		var value = "";
		for (var i = 0; i < json.length; i++) {
			if (i > 0) {
				value += ", ";
			}
			value += json[i][key];
		}
		return value;
	}

});