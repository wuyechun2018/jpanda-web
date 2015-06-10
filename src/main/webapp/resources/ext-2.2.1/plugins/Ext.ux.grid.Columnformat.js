function columnformat(value, metadata, record) {
	//换行
    metadata.attr = "style=\"white-space:normal;\"";
    if (value != null) {
    //显示详细
        return '<div ext:qtip="' + value + '">' + value + '</div>';
    }
}

//ext:qtitle="详细" 


//不换行
function columndetail(value, metadata, record) {
    if (value != null) {
    //显示详细
        return '<div ext:qtip="' + value + '">' + value + '</div>';
    }
}