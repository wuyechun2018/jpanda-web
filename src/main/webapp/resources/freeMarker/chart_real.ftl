<anychart>
  <settings>
    <animation enabled="True" />
  </settings>
  <margin left="0" top="0" right="0" bottom="0" />
  <charts>
    <chart plot_type="CategorizedVertical">
      <chart_settings>
        <legend enabled="True" position="Bottom" align="Center"
          elements_align="elements_align">
          <font size="12" />
          <title enabled="False">
            <font size="15" />
          </title>
          <columns_separator enabled="False" />
        </legend>
        <chart_background enabled="false">
          <inside_margin left="10" top="10" right="10" bottom="10" />
        </chart_background>
        
        <title enabled="true">
          <text>${anychartModle.titleText}</text>
          <font size="15"/>
          <background enabled="false" />
        </title>
        
        <axes>
          <y_axis>
            <major_grid interlaced="true">
              <line color="#1976C3" opacity="0.5" />
            </major_grid>
            <minor_grid interlaced="true">
              <line color="#1976C3" opacity="0" />
            </minor_grid>
            <title enabled="true">
              <text></text>
            </title>
            <labels>
              <format>{%Value}{numDecimals:0}</format>            
            </labels>
          </y_axis>
          <x_axis tickmarks_placement="Center">
            <major_grid interlaced="false">
              <line color="transparent" opacity="0" />
            </major_grid>
            <minor_grid interlaced="false">
              <line color="transparent" opacity="0" />
            </minor_grid>
            <title enabled="true">
              <text></text>
            </title>
          </x_axis>
        </axes>
        <data_plot_background>
          <border enabled="false" />
          <fill opacity="0.1" color="white" />
          <effects enabled="false" />
        </data_plot_background>
      </chart_settings>
      <data_plot_settings default_series_type="Line"
        enable_3d_mode="true" z_aspect="0.5">
        <line_series>
          <tooltip_settings enabled="true" color="Blue">
            <background>
              <border type="Solid"/>
              <fill type="Solid"/>
            </background>
            <format>
            {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}
            </format>
            <font bold="true" size="12" />
          </tooltip_settings>
          <line_style>
            <line thickness="2" />
          </line_style>
          <marker_settings>
            <states>
              <normal>
                <marker type="None"/>
              </normal>
            </states>
          </marker_settings>        
        </line_series>
        <bar_series point_padding="0.2" group_padding="1" shape_type="Cylinder">
          <tooltip_settings enabled="True">
            <format>
               {%SeriesName} 日期: {%Name}{numDecimals:0} 值: {%YValue}
            </format>
            <font bold="true" size="12" />
          </tooltip_settings>
        </bar_series>      
      </data_plot_settings>
      <data>
          <#list anychartModle.series as serie>
				<series name="${serie.seriesName}" type="${serie.seriesType}"> 
					<#list serie.points as point>
						 <#if point.pointValue ??> 
							<point name="${point.pointName}" y="${point.pointValue}" />
						 <#else>
						 	<point name="${point.pointName}" y="0" />
						 </#if> 	
					</#list>
				</series>
		 </#list>
      </data>
    </chart>
  </charts>
</anychart>