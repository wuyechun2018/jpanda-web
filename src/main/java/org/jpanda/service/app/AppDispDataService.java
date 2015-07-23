package org.jpanda.service.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jpanda.common.anychart.AnychartConstant;
import org.jpanda.common.anychart.AnychartModel;
import org.jpanda.common.anychart.AnychartPoint;
import org.jpanda.common.anychart.AnychartSeries;
import org.jpanda.model.app.AppDispData;
import org.jpanda.util.FreeMarkerUtil;
import org.jpanda.util.NativeSqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppDispDataService {
	
	@Autowired
	private NativeSqlHelper sqlHelper;

	/**
	 * 
	 * 功能 :1、获取用于图表展示的XML
	
	 * 开发：ycwu 2014-10-10
	
	 * @return
	 */
	public String getShowXML() {
		String showXML=
				"<anychart>\n" +
						"  <settings>\n" + 
						"    <animation enabled=\"True\" />\n" + 
						"  </settings>\n" + 
						"  <margin left=\"0\" top=\"0\" right=\"0\" bottom=\"0\" />\n" + 
						"  <charts>\n" + 
						"    <chart plot_type=\"CategorizedVertical\">\n" + 
						"      <chart_settings>\n" + 
						"        <legend enabled=\"True\" position=\"Bottom\" align=\"Center\"\n" + 
						"          elements_align=\"elements_align\">\n" + 
						"          <font size=\"12\" />\n" + 
						"          <title enabled=\"False\">\n" + 
						"            <font size=\"15\" />\n" + 
						"          </title>\n" + 
						"          <columns_separator enabled=\"False\" />\n" + 
						"        </legend>\n" + 
						"        <chart_background enabled=\"false\">\n" + 
						"          <inside_margin left=\"10\" top=\"10\" right=\"10\" bottom=\"10\" />\n" + 
						"        </chart_background>\n" + 
						"\n" + 
						"        <title enabled=\"true\">\n" + 
						"          <text>南方公司日售电量</text>\n" + 
						"          <font size=\"15\"/>\n" + 
						"          <background enabled=\"false\" />\n" + 
						"        </title>\n" + 
						"\n" + 
						"        <axes>\n" + 
						"          <y_axis>\n" + 
						"            <major_grid interlaced=\"true\">\n" + 
						"              <line color=\"#1976C3\" opacity=\"0.5\" />\n" + 
						"            </major_grid>\n" + 
						"            <minor_grid interlaced=\"true\">\n" + 
						"              <line color=\"#1976C3\" opacity=\"0\" />\n" + 
						"            </minor_grid>\n" + 
						"            <title enabled=\"true\">\n" + 
						"              <text></text>\n" + 
						"            </title>\n" + 
						"            <labels>\n" + 
						"              <format>{%Value}{numDecimals:0}</format>\n" + 
						"            </labels>\n" + 
						"          </y_axis>\n" + 
						"          <x_axis tickmarks_placement=\"Center\">\n" + 
						"            <major_grid interlaced=\"false\">\n" + 
						"              <line color=\"transparent\" opacity=\"0\" />\n" + 
						"            </major_grid>\n" + 
						"            <minor_grid interlaced=\"false\">\n" + 
						"              <line color=\"transparent\" opacity=\"0\" />\n" + 
						"            </minor_grid>\n" + 
						"            <title enabled=\"true\">\n" + 
						"              <text></text>\n" + 
						"            </title>\n" + 
						"          </x_axis>\n" + 
						"        </axes>\n" + 
						"        <data_plot_background>\n" + 
						"          <border enabled=\"false\" />\n" + 
						"          <fill opacity=\"0.1\" color=\"white\" />\n" + 
						"          <effects enabled=\"false\" />\n" + 
						"        </data_plot_background>\n" + 
						"      </chart_settings>\n" + 
						"      <data_plot_settings default_series_type=\"Line\"\n" + 
						"        enable_3d_mode=\"true\" z_aspect=\"0.5\">\n" + 
						"        <line_series>\n" + 
						"          <tooltip_settings enabled=\"true\" color=\"Blue\">\n" + 
						"            <background>\n" + 
						"              <border type=\"Solid\"/>\n" + 
						"              <fill type=\"Solid\"/>\n" + 
						"            </background>\n" + 
						"            <format>\n" + 
						"            {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}\n" + 
						"            </format>\n" + 
						"            <font bold=\"true\" size=\"12\" />\n" + 
						"          </tooltip_settings>\n" + 
						"          <line_style>\n" + 
						"            <line thickness=\"2\" />\n" + 
						"          </line_style>\n" + 
						"          <marker_settings>\n" + 
						"            <states>\n" + 
						"              <normal>\n" + 
						"                <marker type=\"None\"/>\n" + 
						"              </normal>\n" + 
						"            </states>\n" + 
						"          </marker_settings>\n" + 
						"        </line_series>\n" + 
						"        <bar_series point_padding=\"0.2\" group_padding=\"1\" shape_type=\"Cylinder\">\n" + 
						"          <tooltip_settings enabled=\"True\">\n" + 
						"            <format>\n" + 
						"               {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}\n" + 
						"            </format>\n" + 
						"            <font bold=\"true\" size=\"12\" />\n" + 
						"          </tooltip_settings>\n" + 
						"        </bar_series>\n" + 
						"      </data_plot_settings>\n" + 
						"      <data>\n" + 
						"        <series name=\"日售电量\" type=\"Bar\" color=\"#99CCFF\">\n" + 
						"          <point name=\"01\" y=\"822.943 \"/>\n" + 
						"          <point name=\"02\" y=\"813.714 \"/>\n" + 
						"          <point name=\"03\" y=\"768.35 \"/>\n" + 
						"          <point name=\"04\" y=\"778.074 \"/>\n" + 
						"          <point name=\"05\" y=\"731.419 \"/>\n" + 
						"          <point name=\"06\" y=\"791.681 \"/>\n" + 
						"          <point name=\"07\" y=\"827.541 \"/>\n" + 
						"          <point name=\"08\" y=\"686.95 \"/>\n" + 
						"          <point name=\"09\" y=\"703.032 \"/>\n" + 
						"          <point name=\"10\" y=\"817.105 \"/>\n" + 
						"          <point name=\"11\" y=\"785.719 \"/>\n" + 
						"          <point name=\"12\" y=\"775.357 \"/>\n" + 
						"          <point name=\"13\" y=\"787.171 \"/>\n" + 
						"          <point name=\"14\" y=\"748.407 \"/>\n" + 
						"          <point name=\"15\" y=\"763.224 \"/>\n" + 
						"          <point name=\"16\" y=\"661.958 \"/>\n" + 
						"          <point name=\"17\" y=\"718.663 \"/>\n" + 
						"          <point name=\"18\" y=\"818.818 \"/>\n" + 
						"          <point name=\"19\" y=\"792.858 \"/>\n" + 
						"          <point name=\"20\" y=\"703.824 \"/>\n" + 
						"          <point name=\"21\" y=\"642.3779 \"/>\n" + 
						"          <point name=\"22\" y=\"0 \"/>\n" + 
						"          <point name=\"23\" y=\"0 \"/>\n" + 
						"          <point name=\"24\" y=\"0 \"/>\n" + 
						"          <point name=\"25\" y=\"0 \"/>\n" + 
						"          <point name=\"26\" y=\"0 \"/>\n" + 
						"          <point name=\"27\" y=\"0 \"/>\n" + 
						"          <point name=\"28\" y=\"0 \"/>\n" + 
						"          <point name=\"29\" y=\"0 \"/>\n" + 
						"          <point name=\"30\" y=\"0 \"/>\n" + 
						"          <point name=\"31\" y=\"0 \"/>\n" + 
						"        </series>\n" + 
						"        <series name=\"月计划日均售电量\">\n" + 
						"          <point name=\"01\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"02\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"03\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"04\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"05\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"06\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"07\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"08\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"09\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"10\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"11\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"12\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"13\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"14\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"15\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"16\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"17\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"18\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"19\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"20\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"21\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"22\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"23\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"24\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"25\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"26\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"27\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"28\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"29\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"30\" y=\"578.51927 \"/>\n" + 
						"          <point name=\"31\" y=\"578.51927 \"/>\n" + 
						"        </series>\n" + 
						"        <series name=\"去年同期售电量\">\n" + 
						"          <point name=\"01\" y=\"798.65 \"/>\n" + 
						"          <point name=\"02\" y=\"828.608 \"/>\n" + 
						"          <point name=\"03\" y=\"778.855 \"/>\n" + 
						"          <point name=\"04\" y=\"863.984 \"/>\n" + 
						"          <point name=\"05\" y=\"903.529 \"/>\n" + 
						"          <point name=\"06\" y=\"876.81 \"/>\n" + 
						"          <point name=\"07\" y=\"819.06 \"/>\n" + 
						"          <point name=\"08\" y=\"784.08 \"/>\n" + 
						"          <point name=\"09\" y=\"789.03 \"/>\n" + 
						"          <point name=\"10\" y=\"791.67 \"/>\n" + 
						"          <point name=\"11\" y=\"791.426 \"/>\n" + 
						"          <point name=\"12\" y=\"809.248 \"/>\n" + 
						"          <point name=\"13\" y=\"827.64 \"/>\n" + 
						"          <point name=\"14\" y=\"820.292 \"/>\n" + 
						"          <point name=\"15\" y=\"765.061 \"/>\n" + 
						"          <point name=\"16\" y=\"790.504 \"/>\n" + 
						"          <point name=\"17\" y=\"805.629 \"/>\n" + 
						"          <point name=\"18\" y=\"769.263 \"/>\n" + 
						"          <point name=\"19\" y=\"916.091 \"/>\n" + 
						"          <point name=\"20\" y=\"856.845 \"/>\n" + 
						"          <point name=\"21\" y=\"872.443 \"/>\n" + 
						"          <point name=\"22\" y=\"799.931 \"/>\n" + 
						"          <point name=\"23\" y=\"880.22 \"/>\n" + 
						"          <point name=\"24\" y=\"881.452 \"/>\n" + 
						"          <point name=\"25\" y=\"806.168 \"/>\n" + 
						"          <point name=\"26\" y=\"778.36 \"/>\n" + 
						"          <point name=\"27\" y=\"830.478 \"/>\n" + 
						"          <point name=\"28\" y=\"837.452 \"/>\n" + 
						"          <point name=\"29\" y=\"778.811 \"/>\n" + 
						"          <point name=\"30\" y=\"941.38 \"/>\n" + 
						"          <point name=\"31\" y=\"926.169 \"/>\n" + 
						"        </series>\n" + 
						"      </data>\n" + 
						"    </chart>\n" + 
						"  </charts>\n" + 
						"</anychart>";
		return showXML;
	}
	
	
	/**
	 * 
	 * 功能 :2、使用freemarker后返回用于展示的XML
	
	 * 开发：ycwu 2014-10-9
	 */
	public String getShowXMLByFreeMarker(HttpServletRequest request){
		Map<String, Object> propMap = new HashMap<String, Object>();
		String anyChartXML = FreeMarkerUtil.instance().geneFileStr(request,"chart.ftl", propMap);
		return anyChartXML;
	}
	
	
	/**
	 * 
	 * 功能 :3、获取用于图表展示的XML-使用真实数据
	
	 * 开发：ycwu 2014-10-9
	
	 * @return
	 */
	public String getShowRealDataXML() {
		/***
		String showXML="<anychart>\n" +
						"  <settings>\n" + 
						"    <animation enabled=\"True\" />\n" + 
						"  </settings>\n" + 
						"  <margin left=\"0\" top=\"0\" right=\"0\" bottom=\"0\" />\n" + 
						"  <charts>\n" + 
						"    <chart plot_type=\"CategorizedVertical\">\n" + 
						"      <chart_settings>\n" + 
						"        <legend enabled=\"True\" position=\"Bottom\" align=\"Center\"\n" + 
						"          elements_align=\"elements_align\">\n" + 
						"          <font size=\"12\" />\n" + 
						"          <title enabled=\"False\">\n" + 
						"            <font size=\"15\" />\n" + 
						"          </title>\n" + 
						"          <columns_separator enabled=\"False\" />\n" + 
						"        </legend>\n" + 
						"        <chart_background enabled=\"false\">\n" + 
						"          <inside_margin left=\"10\" top=\"10\" right=\"10\" bottom=\"10\" />\n" + 
						"        </chart_background>\n" + 
						"\n" + 
						"        <title enabled=\"true\">\n" + 
						"          <text>南方公司日售电量</text>\n" + 
						"          <font size=\"15\"/>\n" + 
						"          <background enabled=\"false\" />\n" + 
						"        </title>\n" + 
						"\n" + 
						"        <axes>\n" + 
						"          <y_axis>\n" + 
						"            <major_grid interlaced=\"true\">\n" + 
						"              <line color=\"#1976C3\" opacity=\"0.5\" />\n" + 
						"            </major_grid>\n" + 
						"            <minor_grid interlaced=\"true\">\n" + 
						"              <line color=\"#1976C3\" opacity=\"0\" />\n" + 
						"            </minor_grid>\n" + 
						"            <title enabled=\"true\">\n" + 
						"              <text></text>\n" + 
						"            </title>\n" + 
						"            <labels>\n" + 
						"              <format>{%Value}{numDecimals:0}</format>\n" + 
						"            </labels>\n" + 
						"          </y_axis>\n" + 
						"          <x_axis tickmarks_placement=\"Center\">\n" + 
						"            <major_grid interlaced=\"false\">\n" + 
						"              <line color=\"transparent\" opacity=\"0\" />\n" + 
						"            </major_grid>\n" + 
						"            <minor_grid interlaced=\"false\">\n" + 
						"              <line color=\"transparent\" opacity=\"0\" />\n" + 
						"            </minor_grid>\n" + 
						"            <title enabled=\"true\">\n" + 
						"              <text></text>\n" + 
						"            </title>\n" + 
						"          </x_axis>\n" + 
						"        </axes>\n" + 
						"        <data_plot_background>\n" + 
						"          <border enabled=\"false\" />\n" + 
						"          <fill opacity=\"0.1\" color=\"white\" />\n" + 
						"          <effects enabled=\"false\" />\n" + 
						"        </data_plot_background>\n" + 
						"      </chart_settings>\n" + 
						"      <data_plot_settings default_series_type=\"Line\"\n" + 
						"        enable_3d_mode=\"true\" z_aspect=\"0.5\">\n" + 
						"        <line_series>\n" + 
						"          <tooltip_settings enabled=\"true\" color=\"Blue\">\n" + 
						"            <background>\n" + 
						"              <border type=\"Solid\"/>\n" + 
						"              <fill type=\"Solid\"/>\n" + 
						"            </background>\n" + 
						"            <format>\n" + 
						"            {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}\n" + 
						"            </format>\n" + 
						"            <font bold=\"true\" size=\"12\" />\n" + 
						"          </tooltip_settings>\n" + 
						"          <line_style>\n" + 
						"            <line thickness=\"2\" />\n" + 
						"          </line_style>\n" + 
						"          <marker_settings>\n" + 
						"            <states>\n" + 
						"              <normal>\n" + 
						"                <marker type=\"None\"/>\n" + 
						"              </normal>\n" + 
						"            </states>\n" + 
						"          </marker_settings>\n" + 
						"        </line_series>\n" + 
						"        <bar_series point_padding=\"0.2\" group_padding=\"1\" shape_type=\"Cylinder\">\n" + 
						"          <tooltip_settings enabled=\"True\">\n" + 
						"            <format>\n" + 
						"               {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}\n" + 
						"            </format>\n" + 
						"            <font bold=\"true\" size=\"12\" />\n" + 
						"          </tooltip_settings>\n" + 
						"        </bar_series>\n" + 
						"      </data_plot_settings>\n" + 
						"      <data>\n";
		
		showXML+=	"        <series name=\"日售电量\" type=\"Bar\" color=\"#99CCFF\">\n" ;
		//日售电量
		List<AppDispData> sdlList=this.getDataList("ITEM_VALUE","rsdl","2014-10-01","2014-10-31");
		for(int i=0;i<sdlList.size();i++){
			AppDispData sdlData=sdlList.get(i);
			showXML+="<point name=\""+new SimpleDateFormat("dd").format(sdlData.getDataDate())+"\" y=\""+sdlData.getDataValue()+" \"/>\n" ;
		}
		showXML+="</series>\n" ;
		//月计划日均售电量
		showXML+="<series name=\"月计划日均售电量\">\n" ;
		List<AppDispData> yjhrjsdlList=this.getDataList("ITEM_VALUE","yjhrjsdl","2014-10-01","2014-10-31");
		for(int i=0;i<yjhrjsdlList.size();i++){
			AppDispData sdlData=yjhrjsdlList.get(i);
			showXML+=" <point name=\""+new SimpleDateFormat("dd").format(sdlData.getDataDate())+"\" y=\""+sdlData.getDataValue()+" \"/>\n" ;
		}
		showXML+="</series>\n" ;		
		//去年同期售电量
		showXML+="<series name=\"去年同期售电量\">\n" ;
		List<AppDispData> qntqsdlList=this.getDataList("ITEM_VALUE","rsdl","2013-10-01","2013-10-31");
		for(int i=0;i<qntqsdlList.size();i++){
			AppDispData qntqData=sdlList.get(i);
			showXML+="<point name=\""+new SimpleDateFormat("dd").format(qntqData.getDataDate())+"\" y=\""+qntqData.getDataValue()+" \"/>\n" ;
		}
		showXML+="</series>\n" ;
		showXML+="</data>\n" + 
				"</chart>\n" + 
				"  </charts>\n" + 
				"</anychart>";
		return showXML;***/
		return "";
	}
	
	
	/**
	 * 
	 * 功能 :3、获取用于图表展示的XML-使用真实数据(使用freeMarker,并对Anychart常用属性进行简单的封装)
	
	 * 开发：ycwu 2014-10-10
	
	 * @param request
	 * @return
	 */
	public String getRealXMLByFreeMarker(HttpServletRequest request){
		 List<AnychartSeries> seriesList=new ArrayList<AnychartSeries>();
		 //日售电量
		 List<AppDispData> rsdlList=this.getDataList("ITEM_VALUE","rsdl","2014-10-01","2014-10-31");
		 AnychartSeries serieRsdl=this.getChartSeries("日售电量",AnychartConstant.ANYCHART_SERIESTYPE_BAR,rsdlList);
		 seriesList.add(serieRsdl);
		 
		 //月计划日均售电量
		 List<AppDispData> rjsdlList=this.getDataList("ITEM_VALUE","yjhrjsdl","2014-10-01","2014-10-31");
		 AnychartSeries rjsdlSeries=this.getChartSeries("月计划日均售电量",AnychartConstant.ANYCHART_SERIESTYPE_Line,rjsdlList);
		 seriesList.add(rjsdlSeries);
		 
		//去年同期售电量
		 List<AppDispData> tqDataList=this.getDataList("ITEM_VALUE","rsdl","2013-10-01","2013-10-31");
		 AnychartSeries tqSeries=this.getChartSeries("去年同期售电量",AnychartConstant.ANYCHART_SERIESTYPE_Line,tqDataList);
		 seriesList.add(tqSeries);
		 
		AnychartModel anychartModel = new AnychartModel();
		anychartModel.setTitleText("南方公司日售电量");
		anychartModel.setSeries(seriesList);

		Map<String, Object> propMap = new HashMap<String, Object>();
		propMap.put(AnychartConstant.ANYCHART_ELEMENT_MODEL, anychartModel);
		String anyChartXML = FreeMarkerUtil.instance().geneFileStr(request,"chart_real.ftl", propMap);
		return anyChartXML;
	}
	// 1、代码更简洁  2、避免了在java代码中反复拼凑XML的现象,减少错误可能性  3、对anychart某些属性的更改直接在FreeMarker中进行
	// 4、后续可对AnychatModel的封装更为细致，统一采用一个FreeMarker模板
	
	
	
  
   /**
    * 
    * 功能 :获取数据列表
   
    * 开发：ycwu 2014-10-9
   
    * @param dataType
    * @param dataKey
    * @param startDate
    * @param endDate
    * @return
    */
   public List<AppDispData> getDataList(String dataType,String dataKey,String startDate,String endDate){
	   String sql="SELECT *\n" +
					   "  FROM app_disp_data t\n" + 
					   " WHERE t.data_type = ?1\n" + 
					   "   AND t.data_key =?2\n" + 
					   "   AND to_char(t.data_date, 'yyyy-MM-dd') >= ?3\n" + 
					   "   AND to_char(t.data_date, 'yyyy-MM-dd') <= ?4";
	   
	   return sqlHelper.queryByNativeSQL(sql, new Object[]{dataType,dataKey,startDate,endDate}, AppDispData.class);
   }
	
   
   
   /**
    * 
    * 功能 :生成用于展示的series
   
    * 开发：ycwu 2014-10-10
   
    * @param seriesName
    * @param seriesType
    * @param dataList
    * @return
    */
	public AnychartSeries getChartSeries(String seriesName, String seriesType,List<AppDispData> dataList) {
		AnychartSeries series = new AnychartSeries();
		series.setSeriesName(seriesName);
		series.setSeriesType(seriesType);
		List<AnychartPoint> rjsdlPointList = new ArrayList<AnychartPoint>();
		for (int i = 0; i < dataList.size(); i++) {
			AppDispData appData = dataList.get(i);
			AnychartPoint point = new AnychartPoint();
			point.setPointName(new SimpleDateFormat("dd").format(appData.getDataDate()));
			point.setPointValue(appData.getDataValue().toString());
			rjsdlPointList.add(point);
		}
		series.setPoints(rjsdlPointList);
		return series;
	}

}
