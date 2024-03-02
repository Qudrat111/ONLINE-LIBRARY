package resources;

import Bean.ApiResponse;
import Bean.BasIdBean;

public interface BaseCrudResources <T extends BasIdBean> {
    ApiResponse create (T bean);
    ApiResponse get (Integer id);
    ApiResponse update (T bean);
    ApiResponse delete (Integer id);
}
