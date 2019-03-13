import request from '@/utils/request'

// 查询今日待办事项
export function getTodayMustList(state) {
  return request({
    url: 'api/todayMust/get',
    method: 'get',
    params: state
  });
}


// 删除今日必达事项
export function batchDeleteTodayMust(TodaysMustList) {
    return request({
        url: 'api/todayMust/delete',
        method: 'post',
        data: TodaysMustList
    });
}
