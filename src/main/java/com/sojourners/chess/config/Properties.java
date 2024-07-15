package com.sojourners.chess.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sojourners.chess.board.BoardSize;
import com.sojourners.chess.board.BoardStyle;
import com.sojourners.chess.enginee.Engine;
import com.sojourners.chess.model.EngineConfig;
import com.sojourners.chess.openbook.MoveRule;
import com.sojourners.chess.util.PathUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties implements Serializable
{
	private static final long serialVersionUID = -1410031608529065857L;
	private static Properties prop;
	private BoardSize boardSize;
	private BoardStyle boardStyle = BoardStyle.DEFAULT;
	private boolean stepTip;
	private boolean stepSound;
	private int threadNum;
	private int hashSize;
	private String engineName;
	private List<EngineConfig> engineConfigList = new ArrayList<>();
	private Engine.AnalysisModel analysisModel;
	private long analysisValue;
	private double stageWidth;
	private double stageHeight;
	private double splitPos;
	private double splitPos2;
	private long linkScanTime;
	private int linkThreadNum;
	private boolean linkAnimation;
	private boolean linkShowInfo;
	private boolean linkBackMode;
	private List<String> openBookList;
	private Boolean localBookFirst;
	private Boolean useCloudBook;
	private Boolean onlyCloudFinalPhase;
	private Integer cloudBookTimeout;
	private Integer offManualSteps;
	private MoveRule moveRule;
	private Boolean bookSwitch;
	private int engineDelayStart = 0;
	private int engineDelayEnd = 0;
	private int bookDelayStart = 0;
	private int bookDelayEnd = 0;
	private int mouseClickDelay = 2;
	private int mouseMoveDelay = 0;

	private Properties(BoardSize boardSize, boolean stepTip, int threadNum, int hashSize, String engineName, Engine.AnalysisModel analysisModel,
			long analysisValue, boolean stepSound, double stageWidth, double stageHeight, double splitPos, double splitPos2, long linkScanTime,
			int linkThreadNum, boolean linkAnimation, boolean linkShowInfo, boolean linkBackMode, Boolean localBookFirst, Boolean useCloudBook,
			Boolean onlyCloudFinalPhase, Integer cloudBookTimeout, Integer offManualSteps, MoveRule moveRule, Boolean bookSwitch, List<String> openBookList)
	{
		this.boardSize = boardSize;
		this.stepTip = stepTip;
		this.threadNum = threadNum;
		this.hashSize = hashSize;
		this.engineName = engineName;
		this.analysisModel = analysisModel;
		this.analysisValue = analysisValue;
		this.stepSound = stepSound;
		this.stageWidth = stageWidth;
		this.stageHeight = stageHeight;
		this.splitPos = splitPos;
		this.splitPos2 = splitPos2;
		this.linkScanTime = linkScanTime;
		this.linkThreadNum = linkThreadNum;
		this.linkAnimation = linkAnimation;
		this.linkShowInfo = linkShowInfo;
		this.linkBackMode = linkBackMode;
		this.localBookFirst = localBookFirst;
		this.useCloudBook = useCloudBook;
		this.onlyCloudFinalPhase = onlyCloudFinalPhase;
		this.cloudBookTimeout = cloudBookTimeout;
		this.offManualSteps = offManualSteps;
		this.moveRule = moveRule;
		this.bookSwitch = bookSwitch;
		this.openBookList = openBookList;
	}

	public static synchronized Properties getInstance()
	{
		if (prop == null)
		{
			String path = PathUtils.getJarPath() + "properties";
			File file = new File(path);
			if (file.exists())
			{
				ObjectInputStream os = null;
				try
				{
					os = new ObjectInputStream(new FileInputStream(file));
					prop = (Properties) os.readObject();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					try
					{
						if (os != null)
							os.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			else
			{
				try
				{
					prop = new Properties(BoardSize.MIDDLE_BOARD, true, 1, 16, "", Engine.AnalysisModel.FIXED_TIME, 5000, true, 924, 712, 0.64, 0.6, 100, 2,
							true, true, false, true, true, false, 2000, 15, MoveRule.BEST_SCORE, true, new ArrayList<>());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	public void save()
	{
		ObjectOutputStream os = null;
		try
		{
			String path = PathUtils.getJarPath() + "properties";
			File file = new File(path);
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (os != null)
					os.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
