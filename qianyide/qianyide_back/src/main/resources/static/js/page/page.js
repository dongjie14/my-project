
var couponEntry = $("#couponEntry"), couponItem = couponEntry
		.find(".couponItem");
var couponPageSize = 5, couponRecordsCount = couponItem.length, couponPageCount = Math
		.ceil(couponRecordsCount / couponPageSize);

var couponPageSize = 5, couponRecordsCount = couponItem.length, couponPageCount = Math
		.ceil(couponRecordsCount / couponPageSize);

var paramsObject;
var urlObject;
var callBackObject;
var jumpCallBackObject;
var tableIdObject;
var isAsync;
var pager_container = null; // 分页组件容器ID
var pager_function = createPager; // 构造分页方法

function couponGoToPage(currentPage) {
	var start = (currentPage - 1) * couponPageSize, end = currentPage
			* couponPageSize - 1;
	couponItem.hide();
	for ( var i = start; i <= end; i++) {
		$(couponItem[i]).show();
	}
	$("#couponTablePager").remove();
	if (couponRecordsCount > couponPageSize) {
		couponEntry.append(pager_function(currentPage, couponPageCount,
				"couponTablePager", "couponGoToPage"));
	}
}

function initInvestRecordsTable() {
	$("#" + tableIdObject + "").html("");
}

function initInvestPage(){
	if (pager_container == null) {
		$(".page").html("");
	} else {
		$("#" + pager_container).html("");
	}
}

// 动态创建页标签
function createPager(page) {
	console.log(page);
	var currentPage = Number(page.pageNum);
	var pageCount = Number(page.pages);
	
	var pagerHtml = '';
	pagerHtml += '<div class="invest_page black2"><div class="page">';

	if (currentPage > 1) {
		pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 1)
				+ ');">上一页</a>';
	} else {
		pagerHtml += '<a href="javascript:;" class="disabled">上一页</a>';
	}

	var showTotalPageNum = 8;
	if (pageCount > showTotalPageNum) {
		// 在第四页和倒数第四页之间
		if (currentPage > 4 && currentPage <= pageCount - 4) {
			pagerHtml += '<a href="javascript:jumpPage(1);">1</a>';
			pagerHtml += '<span>...</span>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 2)
					+ ');">' + (currentPage - 2) + '</a>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 1)
					+ ');">' + (currentPage - 1) + '</a>';
			pagerHtml += '<a class="current" href="javascript:;" >'
					+ currentPage + '</a>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 1)
					+ ');">' + (currentPage + 1) + '</a>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 2)
					+ ');">' + (currentPage + 2) + '</a>';
			pagerHtml += '<span>...</span>';
			pagerHtml += '<a href="javascript:jumpPage(' + pageCount + ');">'
					+ pageCount + '</a>';
			// 第四页之前
		} else if (currentPage <= 4) {
			for ( var i = 1; i <= 4; i++) {
				if (i == currentPage) {
					pagerHtml += '<a class="current" href="javascript:;" >' + i
							+ '</a>';
				} else {
					pagerHtml += '<a href="javascript:jumpPage(' + i + ');">'
							+ i + '</a>';
				}
			}
			if (currentPage == 3) {
				pagerHtml += '<a href="javascript:jumpPage(5);">5</a>';
			}
			if (currentPage == 4) {
				pagerHtml += '<a href="javascript:jumpPage(5);">5</a>';
				pagerHtml += '<a href="javascript:jumpPage(6);">6</a>';
			}

			pagerHtml += '<span>...</span>';
			pagerHtml += '<a href="javascript:jumpPage(' + pageCount + ');">'
					+ pageCount + '</a>';
			// 倒数第四页之后
		} else if (currentPage > pageCount - 4) {
			pagerHtml += '<a href="javascript:jumpPage(1);">1</a>';
			pagerHtml += '<span>...</span>';

			if (currentPage == pageCount - 2) {
				pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 4)
						+ ');">' + (pageCount - 4) + '</a>';
			}

			if (currentPage == pageCount - 3) {
				pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 5)
						+ ');">' + (pageCount - 5) + '</a>';
				pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 4)
						+ ');">' + (pageCount - 4) + '</a>';
			}

			for ( var i = pageCount - 3; i <= pageCount; i++) {
				if (i == currentPage) {
					pagerHtml += '<a class="current" href="javascript:;" >' + i
							+ '</a>';
				} else {
					pagerHtml += '<a href="javascript:jumpPage(' + i + ');">'
							+ i + '</a>';
				}
			}
		}
		// 小于页数限额
	} else {
		for ( var i = 1; i <= pageCount; i++) {
			if (i == currentPage) {
				pagerHtml += '<a class="current" href="javascript:;" >' + i
						+ '</a>';
			} else {
				pagerHtml += '<a href="javascript:jumpPage(' + i + ');">' + i
						+ '</a>';
			}
		}
	}

	if (pageCount >= currentPage + 1) {
		pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 1)
				+ ');">下一页</a>';
	} else {
		pagerHtml += '<a href="javascript:;" class="disabled">下一页</a>';
	}
	//跳转到第几页
//	pagerHtml += '<input id="pageNum" value="123"/><input type="button" value="跳转" onclick="jumpPage();"/>';
	pagerHtml += '</div></div>';
	/*console.log(pagerHtml);*/
	return pagerHtml;
}

function jumpPage(page) {
	if (page == undefined) {
		page = $("#pageNum").val();
		if (!/^\d+$/.test(page)) {
			alertc("只能输入数字");
			return;
		}
	}
	getPageFrom(null, null, null, null, page, isAsync);
	if (jumpCallBackObject != undefined && jumpCallBackObject != null) {
		jumpCallBackObject();
	}
}
/**
 * 分页查询方法
 * @param params 查询参数
 * @param url 请求路径
 * @param callBack 回调函数，用户拼接HTML元素
 * @param tableId 拼接的html绑定到那个元素
 * @param curPage 当前页，可不传入
 * @param isAsyncParam 是否异步，true或者false，不传默认为true异步
 * @param jumpCallBackParam 下一页上一页按钮的回调函数，不传入则不调用
 */
function getPageFrom(params, url, callBack, tableId, curPage, isAsyncParam,
		jumpCallBackParam) {
	if (curPage == undefined || curPage == null) {
		curPage = 1;
	}
	if (params != undefined && params != null) {
		paramsObject = params;
	}
	if (url != undefined && url != null) {
		urlObject = url;
	}
	if (callBack != undefined && callBack != null) {
		callBackObject = callBack;
	}
	if (tableId != undefined && tableId != null) {
		tableIdObject = tableId;
	}
	// 是否是异步，如果传入此参数已传入参数为准，未传入默认为异步，
	if (isAsyncParam != undefined && isAsyncParam != null) {
		isAsync = isAsyncParam;
	} else {
		isAsync = true;
	}
	if (jumpCallBackParam != undefined && jumpCallBackParam != null) {
		jumpCallBackObject = jumpCallBackParam;
	}
	paramsObject.pageNum = curPage;
	$
			.ajax({
				dataType : 'json',
				url : urlObject,
				data : paramsObject,
				type : 'POST',
				async : isAsync,
				beforeSend : function() {
					initInvestRecordsTable();
					initInvestPage();
					$("#" + tableId).append(Util.callType.loading("加载中..."));
				},
				success : function(data) {
					initInvestRecordsTable();
					initInvestPage();
					if (data != null ) {
						listData = data.list;
						dataHtml = "";
						if (listData.length > 0) {
							var isLastRow = false;
							for (i = 0; i < listData.length; i++) {
								if (i == (listData.length - 1)) {
									isLastRow = true;
								}
								dataHtml += callBackObject(listData[i], i,
										isLastRow);
							}
							if (dataHtml != "") {

								$(".r5").html(data.totalRecord);

								if (pager_container == null) {
									dataHtml += pager_function(data);
									/*console.log(pager_function(data));*/
								} else {
									$("#" + pager_container).html(
											pager_function(data));
								}

								$("#" + tableIdObject).html(dataHtml);
								
								/*console.log(dataHtml);
								console.log($("#" + tableIdObject));*/
							}
						} else {
							$("#" + tableId).append(
									Util.callType.loading("暂无数据"));
							$(".r5").removeClass("r5");
							$(".load32").removeClass("load32");
						}
					}
				},
				error : function() {
					initInvestRecordsTable();
					initInvestPage();
					$("#" + tableId).append(Util.callType.loading("加载错误"));
				}
			});
}

// 动态创建页标签
function usrInfoPager(page) {
	var currentPage = Number(page.currentPage);
	var pageCount = Number(page.totalPage);
	var pagerHtml = '';
	pagerHtml += '<div class="invest_page"><div class="page">';

	if (currentPage > 1) {
		pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 1)
				+ ');">上一页</a>';
	} else {
		pagerHtml += '<a href="javascript:;" class="disabled">上一页</a>';
	}

	var showTotalPageNum = 8;
	if (pageCount > showTotalPageNum) {
		// 在第四页和倒数第四页之间
		if (currentPage > 4 && currentPage <= pageCount - 4) {
			pagerHtml += '<a href="javascript:jumpPage(1);">1</a>';
			pagerHtml += '<span>...</span>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 2)
					+ ');">' + (currentPage - 2) + '</a>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage - 1)
					+ ');">' + (currentPage - 1) + '</a>';
			pagerHtml += '<a class="current" href="javascript:;" >'
					+ currentPage + '</a>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 1)
					+ ');">' + (currentPage + 1) + '</a>';
			pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 2)
					+ ');">' + (currentPage + 2) + '</a>';
			pagerHtml += '<span>...</span>';
			pagerHtml += '<a href="javascript:jumpPage(' + pageCount + ');">'
					+ pageCount + '</a>';
			// 第四页之前
		} else if (currentPage <= 4) {
			for ( var i = 1; i <= 4; i++) {
				if (i == currentPage) {
					pagerHtml += '<a class="current" href="javascript:;" >' + i
							+ '</a>';
				} else {
					pagerHtml += '<a href="javascript:jumpPage(' + i + ');">'
							+ i + '</a>';
				}
			}
			if (currentPage == 3) {
				pagerHtml += '<a href="javascript:jumpPage(5);">5</a>';
			}
			if (currentPage == 4) {
				pagerHtml += '<a href="javascript:jumpPage(5);">5</a>';
				pagerHtml += '<a href="javascript:jumpPage(6);">6</a>';
			}

			pagerHtml += '<span>...</span>';
			pagerHtml += '<a href="javascript:jumpPage(' + pageCount + ');">'
					+ pageCount + '</a>';
			// 倒数第四页之后
		} else if (currentPage > pageCount - 4) {
			pagerHtml += '<a href="javascript:jumpPage(1);">1</a>';
			pagerHtml += '<span>...</span>';

			if (currentPage == pageCount - 2) {
				pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 4)
						+ ');">' + (pageCount - 4) + '</a>';
			}

			if (currentPage == pageCount - 3) {
				pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 5)
						+ ');">' + (pageCount - 5) + '</a>';
				pagerHtml += '<a href="javascript:jumpPage(' + (pageCount - 4)
						+ ');">' + (pageCount - 4) + '</a>';
			}

			for ( var i = pageCount - 3; i <= pageCount; i++) {
				if (i == currentPage) {
					pagerHtml += '<a class="current" href="javascript:;" >' + i
							+ '</a>';
				} else {
					pagerHtml += '<a href="javascript:jumpPage(' + i + ');">'
							+ i + '</a>';
				}
			}
		}
		// 小于页数限额
	} else {
		for ( var i = 1; i <= pageCount; i++) {
			if (i == currentPage) {
				pagerHtml += '<a class="current" href="javascript:;" >' + i
						+ '</a>';
			} else {
				pagerHtml += '<a href="javascript:jumpPage(' + i + ');">' + i
						+ '</a>';
			}
		}
	}

	if (pageCount >= currentPage + 1) {
		pagerHtml += '<a href="javascript:jumpPage(' + (currentPage + 1)
				+ ');">下一页</a>';
	} else {
		pagerHtml += '<a href="javascript:;" class="disabled">下一页</a>';
	}
	pagerHtml += '</div></div>';
/*	console.log(pagerHtml);*/
	return pagerHtml;
}
