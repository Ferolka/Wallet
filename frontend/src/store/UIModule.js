import { CurrentPage } from "@/models/entities/CurrentPage";
import { LogState } from "@/models/entities/LogPage";

class UIModule  {
    state={
        currentPage:CurrentPage.AUTH,
        logState:LogState.IDLE
    };

    getters={};

    actions={};
    mutations={};
}
export default new UIModule();