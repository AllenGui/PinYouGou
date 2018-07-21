//前端页面控制层
app.controller('brandController', function($scope, $controller, brandService) {
	//继承父类Controller
	$controller('baseController', {
		$scope : $scope
	});
	
	// 查询品牌列表
	$scope.findAll = function() {
		brandService.findAll().success(function(response) {
			$scope.list = response;
		});
	}

	// 分页
	$scope.findPage = function(page, rows) {
		brandService.findPage(page, rows).success(function(response) {
			$scope.list = response.rows;// 显示当前页数据
			$scope.paginationConf.totalItems = response.total;// 更新总记录数
		});
	}

	// 新增&保存
	$scope.save = function() {
		var object = null;
		if ($scope.entity.id != null) {
			object = brandService.update($scope.entity);
		} else {
			object = brandService.add($scope.entity);
		}
		object.success(function(response) {
			if (response.success) {
				$scope.reloadList();
			} else {
				alert(response.message);
			}
		});
	}

	// 查询实体
	$scope.findSingle = function(id) {
		brandService.findSingle(id).success(function(response) {
			$scope.entity = response;
		});
	}

	// 批量删除
	$scope.del = function() {
		if (confirm('确定要删除吗？')) {
			brandService.del($scope.selectIds).success(function(response) {
				if (response.success) {
					$scope.reloadList();// 刷新
					$scope.selectIds = [];
				} else {
					alert(response.message);
				}
			});
		}
	}

	$scope.searchEntity = {};// 定义搜索对象
	// 查询
	$scope.search = function(page, rows) {
		brandService.search(page, rows, $scope.searchEntity).success(
				function(response) {
					$scope.list = response.rows;// 显示当前页数据
					$scope.paginationConf.totalItems = response.total;// 更新总记录数
				});
	}

});