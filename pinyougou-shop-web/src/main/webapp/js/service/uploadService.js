//服务层
app.service('uploadService', function($http) {

	// 上传文件
	this.uploadFile = function() {
		var formData = new FormData();
		// file文件上传框name
		formData.append('file', file.files[0]);
		return $http({
			url : '../upload.do',
			method : 'post',
			data : formData,
			headers : {
				'Content-Type' : undefined
			},
			transformRequest : angular.identity
		});
	}

});
