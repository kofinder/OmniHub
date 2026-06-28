package com.finderbar.omnihub.core.facade

interface BaseCrudFacade<
    ID,
    MODEL,
    SEARCH,
    CREATE,
    UPDATE
> : FindAllFacade<MODEL>,
    FindFacade<ID, MODEL>,
    SearchFacade<SEARCH, MODEL>,
    CreateFacade<CREATE, MODEL>,
    UpdateFacade<ID, UPDATE, MODEL>,
    DeleteFacade<ID>